class 4331 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect23
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.su_empower_ta'
		bOnMultiTarget=True
	End Object
	Desc="초보용 엠파워" //Beginner empawo
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect23',SpecificStage=0)
}