class 2033 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect10
		AttachOn=AM_RA
		AttachBoneName="soulshot1"
		bAbsolute=True
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.it_soul_shot_d_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect11
		AttachOn=AM_RA
		AttachBoneName="soulshot2"
		bAbsolute=True
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.it_soul_shot_d_ca'
	End Object
	Desc="소환수정령탄" //Pet jeongryeongtan
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect10',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect11',SpecificStage=0)
}