class 4334 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect7
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.su_sleep_ta'
		bOnMultiTarget=True
	End Object
	Desc="SSQ 캔슬" //SSQ cancel
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect7',SpecificStage=0)
}