class 4684 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect2
		AttachOn=AM_LH
		AttachBoneName="Dummy05"
		SpawnDelay=2.000000
		bUseCharacterRotation=True
		EffectClass=Class'LineageEffect.mb_valakas_breath_high_fl'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect4
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mb_valakas_breath_ta'
		bOnMultiTarget=True
	End Object
	Desc="발라카스 브레스 상" //Breath balrakaseu Awards
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect2',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect4',SpecificStage=0)
}