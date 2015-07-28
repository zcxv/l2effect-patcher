class 4683 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect0
		AttachOn=AM_LH
		AttachBoneName="Dummy05"
		SpawnDelay=1.900000
		bUseCharacterRotation=True
		EffectClass=Class'LineageEffect.mb_valakas_breath_low_fl'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect3
		AttachOn=AM_LH
		AttachBoneName="Dummy06"
		SpawnDelay=2.100000
		EffectClass=Class'LineageEffect.mb_valakas_breath_low_fo'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect1
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mb_valakas_breath_ta'
		bOnMultiTarget=True
	End Object
	Desc="발라카스 브레스 하" //Balrakaseu breath and
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect0',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect3',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect1',SpecificStage=0)
}