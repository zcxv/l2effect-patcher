class 1425 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect28
		AttachOn=AM_LA
		EffectClass=Class'LineageEffect.s_u807_mage_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect33
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.s_u807_ta'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect36
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_bless_the_body_ta'
		bOnMultiTarget=True
	End Object
	Desc="퓨리피케이션필드" //Blood Fury Vacations field
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect28',SpecificStage=0)
	ShotActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect33',SpecificStage=0)
	ShotActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect36',SpecificStage=0)
}